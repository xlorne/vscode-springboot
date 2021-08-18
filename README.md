# vscode-springboot

lorne 2021-08-18

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7934a4ae-6039-4181-b156-f6099fa52764/Untitled.png)

# Setting remote docker ssh

- create `.vscode/settings.json` file

```java
{
    "docker.host": "ssh://root@10.13.14.123"
}
```

Using SSH requires a supported SSH client, that you have key based authentication configured for the remote host, and that the key is imported into your local SSH agent. See the article on using SSH Keys with Git for details on configuring the agent and adding your key.

[SSH证书登录（免密登录）](https://www.notion.so/SSH-77d3a6fca160472fb5b6184047baf69f) 

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8f19d1fb-23a0-4568-acac-df9a73770f3e/Untitled.png)

# Remote Container: Clone Repository from container volume

- `F1` search :Remote Container : clone repository form container volume
- clone git repository form url :  [https://github.com/1991wangliang/vscode-springboot.git](https://github.com/1991wangliang/vscode-springboot.git)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/69a1275e-a4a9-4348-845a-96894de3bced/Untitled.png)

- entity init project

# SpringBoot Project Build and Setting

- wait docker build and project build

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9d21ac5b-aeb3-4a9e-85a8-fa4f89e59362/Untitled.png)

- note install lombok extension with flow errors.

```java
The Language Support for Java server crashed 5 times in the last 3 minutes. The server will not be restarted.
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/567b36ea-579b-407d-a825-a8bba97de504/Untitled.png)

# Run SpringBoot

- run SpringBootApplication

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/01a87073-f8d0-4064-9860-ae0d9294fc82/Untitled.png)

- open browser see page

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4190a048-e15f-4d07-b9d0-a01cece7c8fa/Untitled.png)

# Remote Container Dev has 2 Ways

There's two variations of this setup. The first is to **create your remote dev container first**, and then **clone your source code into a named volume** since this does not require you to have direct access to the filesystem on the remote host.

Here is a basic `devcontainer.json` example of this setup:

```
{
  "image": "node", // Or "dockerFile"
  "workspaceFolder": "/workspace",
  "workspaceMount": "source=remote-workspace,target=/workspace,type=volume"
}
```

In fact, the **Remote-Containers: Clone Repository in Container Volume...** command in the Command Palette (F1) uses this same technique. If you already have a `devcontainer.json` file in a GitHub repository that references an image or Dockerfile, the command will automatically use a named volume instead of a bind mount - which also works with remote hosts.

The second approach is to **bind mount a folder on the remote machine** into your container. This requires you to have access to the remote filesystem, but also allows you to work with **existing source code** on the remote machine.

Update the `workspaceMount` property in the example above to use this model instead:

```
"workspaceMount": "source=/absolute/path/on/remote/machine,target=/workspace,type=bind,consistency=cached"
```

In either case, to try it out, run **Remote-Containers: Open Folder in Container...**, and select the local folder with the `.devcontainer.json` file in it.

## links:

[Developing inside a Container using Visual Studio Code Remote Development](https://code.visualstudio.com/docs/remote/containers)

[Advanced Container Configuration](https://code.visualstudio.com/docs/remote/containers-advanced#_developing-inside-a-container-on-a-remote-docker-host)
