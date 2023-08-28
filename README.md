![FullStack Factoids Logo](https://github.com/FullStackFactoids/.github/blob/main/profile/fullstackfactoid-github-narrow.png)

---

# FullStack Factoids - Java Trivia Code Samples

Welcome to the FullStack Factoids Java Trivia repository! Dive into the world of Java with code samples corresponding to each trivia question from our YouTube channel. Each trivia question has its own dedicated file, ensuring a streamlined experience as you navigate and explore.

## Prerequisites

Before diving in, ensure you have:

- A computer running macOS, Windows, or Linux.
- Internet connection (for installation).

## Java Installation

### Windows:

1. Visit the official [Oracle Java Downloads page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. Download the latest version for Windows.
3. Run the installer and follow the on-screen instructions.

### macOS:

1. Visit the official [Oracle Java Downloads page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. Download the latest version for macOS.
3. Open the downloaded `.dmg` file and follow the installation instructions.

### Linux:

1. Open a terminal.
2. For Debian-based distributions like Ubuntu, use:
```bash
sudo apt update
sudo apt install openjdk-11-jdk
```
For Red Hat-based distributions like Fedora, use:
```bash
sudo yum install java-11-openjdk-devel
```

## Running the Code Samples

1. Clone this repository:
```bash
git clone https://github.com/FullStackFactoids/java-trivia-code-samples.git
```

2. Navigate to the repository's directory:
```bash
cd java-trivia-code-samples
```

3. Compile and run the desired trivia non gradle dependent code samples:
```bash
javac FileName.java
java FileName
```
Replace `FileName` with the name of the trivia question file (without the `.java` extension) you want to execute.

4. Compile and run the desired trivia gradle dependent code samples:
```bash
cd director-name
./gradlew build  
./gradlew shadowJar
java -cp build/libs/directory-name-all.jar FileName      

```
Replace `FileName` with the name of the trivia question file (without the `.java` extension) you want to execute.
Replace `director-name` with the name of the director of the  `.java` file.
## Contributing

Contributions are always welcome! If you encounter any issues or have suggestions, please open an issue. Direct contributions can be made via pull requests.

## License

This project is licensed under the MIT License. Refer to the `LICENSE` file for more details.

---

Adjust the repository URL in the "git clone" command to match your actual repository URL. This README provides a foundational structure, and you can further customize it to better fit your project's specifics.