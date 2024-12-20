const fs = require("fs");
const path = require("path");
const { exec } = require("child_process");
const readline = require("readline");

// Function to search for a file based on number in the name
function searchFile(directory, numberPart, callback) {
  fs.readdir(directory, { withFileTypes: true }, (err, files) => {
    if (err) {
      console.error(`Error reading directory: ${directory}`);
      return callback(err);
    }

    for (const file of files) {
      const fullPath = path.join(directory, file.name);

      if (file.isDirectory()) {
        // Recurse into sub-directory
        searchFile(fullPath, numberPart, callback);
      } else if (file.name.match(new RegExp(`LC_${numberPart}\\.java`))) {
        // File matches the pattern LC_{number}.java
        return callback(null, fullPath);
      }
    }
  });
}

// Main function to search and open file in VSCode
function openFileInVSCode(numberPart) {
  const startDirectory = process.cwd(); // Start from current working directory
  searchFile(startDirectory, numberPart, (err, filePath) => {
    if (err) {
      console.error("An error occurred:", err.message);
      return;
    }

    if (filePath) {
      console.log(`File found: ${filePath}`);
      console.log("Opening in VSCode...");
      exec(`code "${filePath}"`, (err) => {
        if (err) {
          console.error("Failed to open file in VSCode:", err.message);
        } else {
          console.log("File successfully opened in VSCode.");
        }
      });
    } else {
      console.log(`File with number '${numberPart}' not found in the current directory or its subdirectories.`);
    }
  });
}

// Accept the number input from the user
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question("Enter the question number (e.g., 1111): ", (numberPart) => {
  openFileInVSCode(numberPart);
  rl.close();
});
