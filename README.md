### 测试用JS调用
> 打开浏览器，转到localhost:8080地址，F12打开console端

删除：
```javascript
(async function deletePlay(id) {
          await fetch("http://localhost:8080/player/delete/" + id, {
                    method: "DELETE"
          })
})("1")
```

创建：
```javascript
(async function createPlay() {
let photo = {"name": "Jack"};

          await fetch("http://localhost:8080/player/create”, {
                    method: "POST",
                    headers: {
                              "Accept": "application/json",
                              "Content-Type": "application/json"
                    },
                    body: JSON.stringify(photo)
                    })
                    .then(result => result.text())
                    .then(text => alert(text));
})();
```
