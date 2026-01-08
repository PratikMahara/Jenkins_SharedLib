def call(String sonarServer, String projectName, String projectKey) {

    // 🔴 THIS LINE IS MANDATORY
    def scannerHome = tool(
        name: 'Sonar',
        type: 'hudson.plugins.sonar.SonarRunnerInstallation'
    )

    withSonarQubeEnv(sonarServer) {
        sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectName=${projectName} \
            -Dsonar.projectKey=${projectKey}
        """
    }
}
