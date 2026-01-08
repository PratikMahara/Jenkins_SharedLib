def call(String SonarQubeAPI, String Projectname, String ProjectKey) {

    def scannerHome = tool 'Sonar'   // 👈 THIS IS THE KEY FIX

    withSonarQubeEnv(SonarQubeAPI) {
        sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectName=${Projectname} \
            -Dsonar.projectKey=${ProjectKey} \
            -X
        """
    }
}
