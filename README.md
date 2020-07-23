# Java-Cryptography-Learning

## GUI

Layout class
* the window is seen as a list of slots
* every widget 
	* can have one , more slot
	* can ocuppy the first-half , secon-half ,etc.
* decouples the GUI functionality and aspect

## Implementation

### Graphics package : javax.swing

Classes :
* MainGUI ``` main windows```
* Layout ``` creates the layout of buttons ```
* CipherGUI
* Cipher
	* Caesar
	* MD5Cipher
	* DummyCipher ```does nothign```

MainGUI structure
* first page ``` selection page ```
* second page ``` execution page ```
	* has a back button
