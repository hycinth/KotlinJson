# KotlinJson
kotlin手动解析（仿swiftJson）

需要添加json
implementation 'com.fasterxml.jackson.core:jackson-databind:2.10.0.pr1'

1.基本类型
JsonParser.parse(jsonString)["num"].intValue
2.对象
ListBean(json)
3.list
JsonParser.parse(jsonString)["list"].arrayValue.map { subJson ->
                    ListBean(subJson)
                }
                
 数据类
class ListBean(json: Json) {
    var num:Int = json["num"].intValue
    var id :Int = json["id"].intValue

}





项目还不完善，希望能得到您的宝贵意见或建议
邮箱：1093528347@qq.com
