# xargsCommandShell$: Project ~ ECS 160


### The Java Runtime exec() method
*Resource:*
https://www.geeksforgeeks.org/java-runtime-exec-method/
The exec() method belongs to the Runtime class, which represents the runtime environment of an application. You obtain a ***Runtime object*** by using the getRuntime() method.

Under the hood, exec() uses a ProcessBuilder to start the native process.


## The variants of the exec() command in Java
- **exec(String command) :*** This variant takes a single string command as input and executes it. For example, you can use it to open a text editor:

```
Runtime.getRuntime().exec(“notepad.exe”);
```
- ****exec(String[] cmdarray) :**** Use this variant to execute a command and its arguments as separate strings in an array. Here’s how you can list files in a directory:
```
String[] cmd = {"ls", "-l", "/path/to/directory"};
```

#### What does the 'xargs' command do?
So, certain commands take input from both the standard input, *AND* as a command line argument. However, there are commands that are designed to take input only as an argument. To be able to process the standard input (for the commands that only take input as the argument, and not as input from stdin), we utilize the 'xargs' command.

An example of using the 'xargs' command:

find [location] -name "[search-term]" -type f | xargs [command]

The example we could write is the following...

```
find /home/marko . -name '*.sh' -type f | xargs rm -f
```

What this does, is...
- The find command finds all the files with the .sh extension, The list of files is piped to xargs, which would then use rm to delete them.



https://kohlschutter.github.io/junixsocket/filedescriptors.html#:~:text=File%20descriptors%20are%20identifiers%20(handles,sockets%2C%20pipes%20or%20other%20resources.&text=providing%20a%20sophisticated%20casting%20mechanism,Redirect%20.