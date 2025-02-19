def call(String projectName, String imageTag, String credentialsId) {
    echo "This is pushing the image to Docker Hub"

    withCredentials([usernamePassword(credentialsId: credentialsId, 
                                      usernameVariable: 'DOCKER_HUB_USER', 
                                      passwordVariable: 'DOCKER_HUB_PASS')]) {
        sh """
            docker login -u ${DOCKER_HUB_USER} -p ${DOCKER_HUB_PASS}
            docker image tag ${projectName}:${imageTag} ${DOCKER_HUB_USER}/${projectName}:${imageTag}
            docker push ${DOCKER_HUB_USER}/${projectName}:${imageTag}
        """
    }
}
