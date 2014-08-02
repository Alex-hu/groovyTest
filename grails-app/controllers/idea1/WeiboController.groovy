package idea1

import grails.plugins.rest.client.RestBuilder

class WeiboController {

    def index() {
        def rest = new RestBuilder()
        def resp = rest.get("https://api.weibo.com/2/statuses/public_timeline.json?access_token=2.006ZlAUCjhKUVD52b73a1105MzjvBE"){
            accept "application/json"
        }
//        try { // expect an exception from a 404 response:
//            twitter.head path : 'public_timeline'
//            assert false, 'Expected exception'
//        }
//        catch( ex ) { assert ex.response.status == 404 }
//
//        assert twitter.head( path : 'home_timeline.json' ).status == 200

        render "Hello my grails world huzhongyuan!" + resp.json
    }

    def showTop() {
        def rest = new RestBuilder()
        def resp = rest.get("https://api.weibo.com/2/statuses/public_timeline.json?access_token=2.006ZlAUCjhKUVD52b73a1105MzjvBE"){
            accept "application/json"
        }
        return [mesgList: resp.json.statuses];
    }
}
