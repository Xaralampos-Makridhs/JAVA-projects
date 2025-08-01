# 🔐 Crack Password using MD5 algorithm

## What is MD5?

MD5 stands for Message-Digest Algorithm 5.  
It is a cryptographic hash function that takes an input (like a password, file, or string) and produces a fixed-length 32-character hexadecimal hash.

## How it works?

MD5 takes input of any size and converts it into a fixed 128-bit (16 bytes) hash value.  
The output is usually displayed as a 32-character hexadecimal string.  
It is a one-way process: you can generate the hash from the original input, but you cannot retrieve the original input from the hash.  
Nowadays, MD5 is considered outdated and insecure for use in security-critical systems.


## Features

The application offers a user-friendly interface, supports input of custom dictionary files (.txt) containing candidate passwords, provides error handling, supports all MD5 hashes, and is case sensitive.

## Struct
-`Main.java`.

-`MD5passwordCrackGUI.java`.

### User Interface

<img width="800" height="567" alt="MD5" src="https://github.com/user-attachments/assets/6c01e727-968b-466c-9e00-7c51bae5507f" />

## How to execute

To run the program, create a .txt file and write random codes, one per line.  
If you want to double-check the hash and the result, visit: `https://md5decrypt.net/en/#google_vignette`.  
Run the program as a Java application.

## Libraries that are used

The program uses the library `bcprov-jdk18on-1.81.jar`, which is essential for the program's execution.
