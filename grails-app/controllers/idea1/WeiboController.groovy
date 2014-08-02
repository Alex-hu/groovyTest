package idea1

import grails.plugins.rest.client.RestBuilder

class WeiboController {
    def rest = new RestBuilder()
    def index() {
        def resp = rest.get("https://api.weibo.com/2/statuses/public_timeline.json?access_token=2.006ZlAUCjhKUVD52b73a1105MzjvBE"){
            accept "application/json"
        }
        return [mesgList: resp.json.statuses];
    }

    def showTop() {
        def resp = rest.get("https://api.weibo.com/2/statuses/public_timeline.json?access_token=2.006ZlAUCjhKUVD52b73a1105MzjvBE"){
            accept "application/json"
        }
        return [mesgList: resp.json.statuses];
    }
}
