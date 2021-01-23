package dev.inmo.tgbotapi.passport

import dev.inmo.tgbotapi.types.passport.EncryptedAndBase64EncodedData

//actual val privateKey = """-----BEGIN RSA PRIVATE KEY-----
//MIIEowIBAAKCAQEAt0hdC7xyjrRAXxqrd5i06haPfKLdAvRWsPy2yWtYTFom5dBj
//atMUnFKekTwsmhKbRPBoqF7Da0RF+/Y9q9zmZv05+tNz2FEYGJ6o7r/gdAEX+pKs
//Hd84avm9RahGOwbZgcE8r8Md/tg/ZJCSMsVElzM/Gw02+U1uJQE4n/E2AATbRl0M
//oWdyXjh6Zk6HMiTCvhtQOHoMa9yI00wmHVAlZonovZSRQ2mqfwPlbkDhjsDUQMZp
//WcSPQblAd8FLcWsR1Mh86rQl1GxZVWYONaNwoeATe4p6Ng438HCL7jO7nc4jXJwp
//xqwGI9eUYlHolApBeMQK7oEYDTQ+e0iTvFryPQIDAQABAoIBAAnV81BW65rm53Fz
//H/KKGmNZlJeuscefzysuVKzYeuOWDvJUTZGFBF0jPekzXn1iNDzt3d/zPe96uXq9
//CzA26ZJrUno4cMYSDAX+NbiiSWxQRrYmut/bg86R2mtrjWFLi86fzR7tjKWJe1Vt
//QLtCxNyMXn2YJvQYCKopt501t50mjkgR3xM375cfVmpomcZXh1K+z4ZxFVzivjvK
//ZAga3BPQ/hd6dhnwUdB/yFZFao1dDmsvJVjsnjpnWD3uqtciTeg2iqtXVLpaLfbJ
//gWOt5P94uIP5r1+qvyrrPXzUGONm4l+43zgvleEgAXWGxnutsYaFfazVQ6qOVyE7
//fGMQfcECgYEA5Zt1fwTVoYIohq4Do/y5TnNcoj4AajXZU1OutFcPM3aNex16UPBW
//hP7Gakq3TwTKxEILDqOwo86IJuG+lX18kUwaj1f/3T0kDFvE6iLimiPYRNByog4c
//Z5Kwqn+vrnl4ciRDoz7jJsURms2PE7mYV7bndA24Gb0FZJRWiB1xI+0CgYEAzFm7
//uTSyzacTsqorkyUFIwoGgMIE5NDBQNCVhflJcrmuHRYNwxkH9HRCXqyeHKLiNPRa
//zAoBo3WynjActoy0tFJ90qZI1203iT9BMRbPDiZEXnMH4MrWmk7e7poAUsPVKaRr
//hxvHjr2gTOLY0ClolMvnyNxZcZ/jBxAG0WwK3ZECgYEAwSkdmbQZfPwg19zBF05f
//Ho6SmbMLak7O+/jkerbbBPJxZ+eOpVTrlIs5pOYifImNg7oDz1cKHWR8yikTynN9
//PkcF+R2RFTCAiR0S9d5PQFlzccDjD05Lux5/HZC53VA3cd7sQAOB2XXkr5TLD08N
//yI0I/mskPBL23Hymp3ANZKkCgYAO2fqttCnGjnz9ACcYk5ky+biNRQyMAKv65O3p
//BbwTzXDdBkxLwJb2ajikntEC7ceY56VtrNB/q78mhgKgNcuwS0p/s7wZhAOEQwee
//5LR5p8hSQPPyn2tHXbIQDzs0yKzGUP/LmvY+5oMu81Gkl03VephG3dTWUDN0wPJt
//5/dGMQKBgE++3BNLLV8siedqwjhSrRB/KmpbLPtoOUlRJYBfG+oITgl/d/W2NKOg
//C5GztdiZUKlHsvvcYoAAWrgEE3bKg+D7GI15yzAjQQZH6AOgL+CEnunIHBaxEEgG
//RS39yB/kPcn9ZtvcJd9v8myQnQjhco8Z2RUwb6IUIoOBvZlSGhGe
//-----END RSA PRIVATE KEY-----"""
//actual val encryptedLoremIpsum: EncryptedAndBase64EncodedData = "KeuPVezTbMW4MvOGJFTAt34PRaL9iepGb1g4QEi5EQYjKXeXo7RytFOCVx6pW9O/uoMWhl+cX32kNqJVWyK7a22kuhnNT2+aiXqEpuh+madx+LK1zUvGDR1A1Mrf3fFOugcnadCQKICiqvl9cFdqsBkJQOFEs9qj5wiu1F57kekuHLWI7ZnHOojkRNq7l1aCHL0DxcLCfZW5CtWAi8g/zUE5WnGd+vUZ+hqc1vnehDul8JE8YUQbAiIxetzba9XoWouTHYZRZcNCztDbrRBYnq2UCcI5adEwQ3VNcES0lIjRuwn1BBWpvk7VOjqh+4c2tSebDX5AkqrO8XwQYwo8OwvZF+hUXFRK6QLHd4B1JQIdygCaEODG0X353upiEKJXDBqv/ZMXR9KqYZBZEfu48ZM/J6heNjVSOP4TSDrXywJgIOieu8mrQ4d7Or7Twnsu/B+bqS37PvVlfU4wHLl7ehXFj4Kusat6cIrb0R4F/Y3fL4+FcfEsk4ioEAndYBFrc1S11vo/TkcuFnXtqrr181gC5JD5LtsUH6sst36vE/JdL/UwTGqhu+rDUcgvr7FiunkasWBnzCtFs58JJrRycUKPzyKINS16GkY8yYtp7xJXBGPYOFM+J7npcKW7P41j1KceDaUArjph2yIELEXCr8qUZzWXZdrw96Te8gLi99c="