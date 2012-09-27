package approver

import org.artifactory.client.ArtifactoryConnector

import static org.apache.commons.lang.StringUtils.removeStart

class ApproverController {

    List<String> pendingArtifacts

    def list() {
        def url = 'http://repo-demo:8081/artifactory'
        def artifactory = ArtifactoryConnector.create url, 'admin', 'password'

        //if selection was already made
        asList(params.pendingArtifacts).each {
            def split = it.split('/')
            def path = removeStart(it, "${split[0]}/")
            def repo = split[0]
            artifactory.repository(repo).file(path).setProps(['approver.status': 'approved'])
        }

        pendingArtifacts = artifactory.searches().itemsByProperty().property('approver.status', 'pending').doSearch().collect {
            removeStart(it, "${url}/api/storage/")
        }
    }

    private static String[] asList(String... params) {
        return params
    }
}

