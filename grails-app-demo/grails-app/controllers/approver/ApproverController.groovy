package approver

import org.artifactory.client.ArtifactoryConnector

import static org.apache.commons.lang.StringUtils.removeStart

class ApproverController {

    List<String> pendingArtifacts

    def list() {
        def url = 'http://localhost:8080/artifactory'
        def artifactory = ArtifactoryConnector.create url, 'admin', 'password'
        asList(params.pendingArtifacts).each {
            def split = it.split('/')
            def path = removeStart(it, "${split[0]}/")
            def repo = split[0]
            artifactory.repository(repo).file(path).setProps([status: "approved"])
        }
        pendingArtifacts = artifactory.searches().itemsByProperty().property('status', 'pending').doSearch().collect {
            removeStart(it, "${url}/api/storage/")
        }
    }

    private String[] asList(String... params) {
        return params
    }
}

