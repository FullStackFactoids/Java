import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.learning.config.Sgd;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import java.io.IOException;

public class Sample10 {
    public static void main(String[] args) {
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder() // Builder for a MultiLayerNetwork (i.e. a neural network with multiple layers)
                .updater(new Sgd(0.1))
                .list()
                .layer(new DenseLayer.Builder().nIn(784).nOut(250)  // 2 layers
                        .activation(Activation.RELU)
                        .build())
                .layer(new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD) // Negative log likelihood
                        .activation(Activation.SOFTMAX)
                        .nIn(250).nOut(10).build())
                .build();
        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();

        System.out.println("Model initialized!");

        try {
            // Load training data
            DataSetIterator mnistTrain = new MnistDataSetIterator(128, true, 12345); // Batch size: 128, train = true, seed = 12345

            // Train the model
            for (int i = 0; i < 10; i++) {  // For simplicity, we're just doing 10 epochs
                model.fit(mnistTrain);
                mnistTrain.reset();
            }

            // Load testing data
            DataSetIterator mnistTest = new MnistDataSetIterator(128, false, 12345);

            // Evaluate the model
            Evaluation eval = model.evaluate(mnistTest);
            System.out.println(eval.stats());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading the MNIST dataset.");
        }
    }
}
