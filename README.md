# vscode-springboot docker-compose (postgresql + springboot-web)

lorne 2021-08-18

![image](https://user-images.githubusercontent.com/5245347/129875365-70437e3d-1286-482e-ab12-4200dcc80a1a.png)


# Setting remote docker ssh

- create `.vscode/settings.json` file

```java
{
    "docker.host": "ssh://root@10.13.14.123"
}
```

Using SSH requires a supported SSH client, that you have key based authentication configured for the remote host, and that the key is imported into your local SSH agent. See the article on using SSH Keys with Git for details on configuring the agent and adding your key.

![image](https://user-images.githubusercontent.com/5245347/129875629-4c791b91-bafd-4e87-bf27-73431529abaa.png)


# Remote Container: Clone Repository from container volume

- `F1` search :Remote Container : clone repository form container volume
- clone git repository form url :  [https://github.com/1991wangliang/vscode-springboot.git](https://github.com/1991wangliang/vscode-springboot.git)

![image](https://user-images.githubusercontent.com/5245347/129875662-6bb2f421-379c-481a-a559-e7173e030d22.png)

- entity init project

# SpringBoot Project Build and Setting

- wait docker build and project build

![image](https://user-images.githubusercontent.com/5245347/129875693-3de61da5-af44-4985-8c67-58218bfc670f.png)

- note install lombok extension with flow errors.

```java
The Language Support for Java server crashed 5 times in the last 3 minutes. The server will not be restarted.
```
>install lombok for Language Support for Java   

![image](https://user-images.githubusercontent.com/5245347/129875717-5fcfa1b5-e9e3-4fdc-a2ab-a1d7cc3c83ff.png)

# Run SpringBoot

- run SpringBootApplication

![image](https://user-images.githubusercontent.com/5245347/129875756-5079739c-29b0-4259-b4da-2bb985e871d9.png)

- open browser see page

![image](https://user-images.githubusercontent.com/5245347/129875801-39d16e78-b1a0-42e8-a472-19a1b963693f.png)


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
