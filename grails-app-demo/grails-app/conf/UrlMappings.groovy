class UrlMappings {

	static mappings = {
//		"/$controller/$action?/$id?"{
//			constraints {
//				// apply constraints here
//			}
//		}

		"/"(view:"/index")
        "/approver"(controller: "approver", action: "list")
		"500"(view:'/error')
	}
}
