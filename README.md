# Spring Boot With Kubenetes ConfigMap

### For running this on kubernetes

`minikube start`

## Set docker env
To be able to work with the docker daemon on your mac/linux host use the docker-env command in your shell:

`eval $(minikube docker-env)`

**you should now be able to use docker on the command line on your host mac/linux machine talking to the docker daemon inside the minikube VM:**

## Build image (in the same terminal)
`docker build -t spring_k8s_reload . `

## Run in minikube
`sudo kubectl run spring-k8s --image=spring_k8s_reload --image-pull-policy=Never`

## Check that it's running
`kubectl get pods`

 
 ## Port Forward for access application 
 
 `sudo kubectl port-forward <pod_name> 8000:8080`

 `curl http://localhost:8000/welcome`
 
 ##Create configmap
 
 `kubectl create -f config-map.yml`
 
 ##Edit configmap

`kubectl edit configmap spring-reload-example`

After making changes in the configmap `curl http://localhost:8000/welcome` will give you the updated value.


##For Using the configmap inside 
1. Create a Service account using the sa.yaml `kubectl create -f sa.yaml`
2. Create a role using role.yaml `kubectl create -f role.yaml`
3. Create a role with service account `kubectl create -f rb.yaml`
4. Create a pod with this service account assigned `kubectl create -f pod.yaml`

**Another way of editing configmap**

*create configmap using properties file*
`kubectl create configmap spring-reload-example --from-file config-value.properties` 

Now, to make changes to this config-value.properties file and run following command

`kubectl create configmap spring-reload-example --from-file config-value.properties -o yaml --dry-run | kubectl replace -f -`

This will replace the existing configmap with new value which will be reflected in application.