package idea1

class User {
    String name
    String id
    String gender
    String email
    String password
    Date createDate
    static constraints = {
        name(size: 10..50)
        id(matches: /\d{8}/)
        gender(inList: ['男', '女'])
        email(email: true)
        createDate()
    }
}
