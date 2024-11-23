# Containers

### Why do you need containers ?  
To be able to use an application in any environment without having to worry about the compatibilities between libraries, OSs, & frameworks.

Containers are completely isolated environments, they can have their own processes or services,
their own networking interfaces, their own mounts just like VMs except they all share the same OS kernel.

### Docker  
Containerizes applications.   
Runs each service with its own dependencies in separate containers.


## Operating Systems
OS (Operating System) s consist of two things: 
1. An OS Kernel
2. A set of software

- The OS kernel interacts with the underlying hardware (remains the same mostly - e.g., Linux for Ubuntu)
- It's the software that makes the OSs different (could be the UI, compilers, drivers, etc.)


## Docker
Docker containers share the underlying kernel. What does it mean ?

Let's say we have a system with an Ubuntu OS with Docker installed on it.
Docker can run any flavour of OS on top of it as long as they all are based on the same kernel, In this case, Linux.
So basically, the docker containers only have the additional software required for the system's OS to run the application.

Docker utilizes the underlying kernel of Docker host, which works with all the OSs.

What about the OSs that do not share the same kernel ? Like Windows & Ubuntu ??

So, we won't be able to run a windows based container on a Docker host with Linux OS on it. You will need Docker host with windows OS on it.


## VM vs Container
- So, docker doesn't help with environments with different OS kernels. This is the difference between VMs and containers.   

- Containers are meant to containerize the applications with the required dependencies of frameworks, libraries, etc and to ship those containers ready to run later.   
A VM has its own OS in it along with the application & dependencies.

- VMs consume more space and resources compared to Docker. 

- And docker is faster than VMs.

- Docker has less isolation as more resources like OS kernel is shared between the containers unlike VMs.

## Docker Containers & Images

Docker image is the template/package that we ship across.
We create docker containers from that image, which are running instances of it.
Docker containers are isolated and have their own environment and set of processes.


There are a lot of public docker images available in the docker hub/repository that we can get and create containers to use.
If not present, you can create the docker image yourself and push to the docker hub.


Usually developers create/develop the applications. 
The Ops (Operations) people deploy and manage the applications in production environments.
They do that by following a set of instructions like what host, dependencies, etc.

Docker eases the gap between developers and ops.

Developers can create the applications and share the docker image. Which then Ops can use the image and then create containers of it to test amd deploy across.


## Container Orchestration

What if your container relies on other containers like databases, messaging services or other backend services ?

What if the number of users increase, and you need to scale your application  & scale down when the loaded decreases?

You need a platform to orchestrate the connectivity between the containers and automatically scale based on the load.

Kubernetes is a tool for this container orchestrations by Google. 
Docker has its own such technology called Docker Swarm.

[More about Kubernetes](kubernetes.md)







