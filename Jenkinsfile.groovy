node('maven') {
    stage('build') {
        echo 'building app :)'
        openshiftBuild(buildConfig: 'meu-workshop-minha-vida', showBuildLogs: 'true')
    }
    stage('verify') {
        echo 'dummy verification....'
    }
    stage('deploy') {
        input 'Manual Approval'
        openshiftDeploy(deploymentConfig: 'meu-workshop-minha-vida')
    }
}
