def call() {
    sh '''
    docker run --rm -v $(pwd):/workspace aquasec/trivy fs /workspace
    '''
}
