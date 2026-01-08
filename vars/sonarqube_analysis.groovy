def call(String sonarServer, String projectName, String projectKey) {

    def scannerHome = tool(name: 'Sonar', type: 'hudson.plugins.sonar.SonarRunnerInstallation')

    withSonarQubeEnv(sonarServer) {
        sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectName=${projectName} \
            -Dsonar.projectKey=${projectKey} \
            -X
        """
    }
}
