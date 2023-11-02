#!/bin/bash

# Define the Gradle version you want to install
GRADLE_VERSION="9.0"

# Define the installation directory
INSTALL_DIR="/usr/local/gradle"

# Download and extract Gradle
sudo mkdir -p $INSTALL_DIR
sudo curl -L "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" -o /tmp/gradle-${GRADLE_VERSION}-bin.zip
sudo unzip -d $INSTALL_DIR /tmp/gradle-${GRADLE_VERSION}-bin.zip

# Add Gradle to your PATH
echo "export PATH=\$PATH:$INSTALL_DIR/gradle-${GRADLE_VERSION}/bin" >> ~/.bash_profile

# Clean up temporary files
#rm /tmp/gradle-${GRADLE_VERSION}-bin.zip

# Reload your shell
source ~/.bash_profile

# Display Gradle version
gradle --version




# Check if Gradle is installed
if ! command -v gradle &> /dev/null; then
    echo "Gradle is not installed. Please install Gradle and try again."
    exit 1
fi

# Navigate to the directory where your Bash script is located
cd "$(/Users/Desktop/4485/4485-OnlineTutoringApp-main "$0")"

# Build the Gradle project in the specified project directory
# Replace '/path/to/your/gradle/project' with the actual path to your Gradle project
(cd /Users/Desktop/4485/4485-OnlineTutoringApp-main/SpringDataJPA && gradle build)

# Check for build success
if [ $? -ne 0 ]; then
    echo "Build failed. Check for errors and try again."
    exit 1
fi

# Run your Java application using Gradle
(cd /Users/Desktop/4485/4485-OnlineTutoringApp-main/SpringDataJPA && gradle bootRun)

