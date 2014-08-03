package idea1

import grails.plugins.rest.client.RestBuilder

class WeiboController {
    def rest = new RestBuilder()

    def resp = rest.get("https://api.weibo.com/2/statuses/public_timeline.json?access_token=2.006ZlAUCjhKUVD52b73a1105MzjvBE"){
        accept "application/json"
    }

    def index() {
//        def resp = rest.get("https://api.weibo.com/2/statuses/public_timeline.json?access_token=2.006ZlAUCjhKUVD52b73a1105MzjvBE"){
//            accept "application/json"
//        }
        def data = resp.json.statuses
        //后台分页处理 being.
        def page = new Page()
        page.pageCount = data.size() / page.size + (data.size() % page.size > 0 ? 1 : 0)
        int needPage = Integer.valueOf(request.getParameter("p") == null ? 1 : request.getParameter("p"))
        page.numberOfPage = needPage
        page.pageNum = needPage
        int startAt = (needPage - 1) * page.size
        int endAt = ((startAt + page.size) > data.size()? data.size() : (startAt + page.size)) - 1
        //end.

        return [mesgList: data.getAt(startAt.. endAt), page: page];
    }

    def refreshData() {
        resp = rest.get("https://api.weibo.com/2/statuses/public_timeline.json?access_token=2.006ZlAUCjhKUVD52b73a1105MzjvBE"){
            accept "application/json"
        }
        redirect(uri: "/weibo/index")
    }

    def showTop() {
        def resp = rest.get("https://api.weibo.com/2/statuses/public_timeline.json?access_token=2.006ZlAUCjhKUVD52b73a1105MzjvBE"){
            accept "application/json"
        }
        def page = new Page()
        return [mesgList: resp.json.statuses, page: page];
    }
}
