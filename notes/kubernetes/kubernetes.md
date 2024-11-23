# Kubernetes

While **Docker Swarm** is easy to set up and use, it lacks some advanced features required for complex applications.

And **Mesos** by Apache is difficult to set up though it provides a lot of advanced features.

**Kubernetes** is the most popular of it all, a little bit difficult to set up but provides with lot of options to customize deployments supporting complex architectures.

Kubernetes is now supported on all public cloud service providers like GCP, Azure and AWS.

### Advantages of Container Orchestration:
- The application is highly available since the hardware failures cannot bring it down as its deployed in multiple instances.
- User traffic is balanced across the various containers.


## Architecture

**Node** - A machine (physical or virtual) on which Kubernetes is installed.
Here is where the containers are launched by Kubernetes.

What if the node on which your application is running fails ?
So you need to have multiple nodes for backup, also helps in sharing the load.

One is the Master Node, and the others are Worker Nodes (Minions)

**Cluster** - A group of nodes

Who manages the cluster?  
Where is the info about the members of the cluster (nodes) stored ?  
How are the nodes monitored?  
When a node fails, how do you move the workload on it to another ?  
**Master** does it all.

Master is another node with Kubernetes installed in it, and is configured as 'master'.
It watches over the other nodes in the cluster and is responsible for the actual orchestration of containers on the worker nodes (non-master nodes).

### Components

When you install Kubernetes, you get the following in it:  

**1. API Server**  
Acts as the frontend for Kubernetes. Users, management devices, CLIs, all talk to the API server to interact with the Kubernetes cluster.

**2. ETCD Key Store**  
It's a distributed reliable key value store used by Kubernetes to store all data used to manage the cluster.

**3. Kubelet**  
The agent that runs on each node. Responsible for making sure the containers are running on the nodes as expected

**4. Container Runtime**  
The underlying software that is used to run containers, its Docker in our case.

**5. Controllers**  
Brain behind the orchestration. They're responsible for noticing and responding when nodes or endpoints go down.
These make the decisions to bring up new containers in such cases.

**6. Schedulers**  
Responsible for distributing the work across multiple nodes

- The Container Runtime & Kubelet are present in the Worker Node / Minion / Slave
- 
- The API Server is present in the Master Node / Master

- The Kubelets in worker nodes communicate with the Master to provide health info about the worker node,
carry out actions requested by the master on the worker nodes.

- All the info gathered by the Master in stored in ETCD Key Value Store in the Master Node

- Controllers and Schedulers are also present in the Master Node


## KubeCtl

We have a command line tool for Kubernetes called Kube Command Line Tool / KubeCTL / Kube Control.  

It is used to deploy and manage applications on a Kubernetes cluster, to get cluster info, to get the status of other nodes, etc.


### Basic `kubectl` Commands

1. To **deploy an application** on the cluster
```shell
kubectl run hello-minikube
```


2. To **view info about the cluster**
```shell
kubectl cluster-info
```

3. To **list all nodes in the cluster**
```shell
kubectl get nodes
```

## Kubernetes Pods

- Kubernetes doesn't deploy the docker containers directly on the worker nodes.
The containers are encapsulated into Kubernetes objects called **Pods**.

- A pod is a single instance of an application. It's the smallest object you can create in Kubernetes.

- When the users increase, the application will need additional instances to share the load.
For this, we don't put another container in the same pod. We create another pod with a new container of the application.
Each pod serves as an instance.

- If the current Node reached its maximum capacity of instances/pods, 
you can always deploy additional pods in new nodes to expand the cluster's physical capacity.

- Pods have 1-to-1 have relationship with containers. However, a pod may contain different types of containers.
The two containers can communicate with each other referring to as localhost, since they're on the same network





