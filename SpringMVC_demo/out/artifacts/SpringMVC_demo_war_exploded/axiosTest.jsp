<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
    <script src="https://cdn.bootcss.com/qs/6.7.0/qs.min.js"></script>
    <script src="https://cdn.bootcss.com/axios/0.19.0-beta.1/axios.min.js"></script>
</head>

<body>

<div id="app">


    <input type="text" name="name" v-model="user.name">
    <input type="password" name="password" v-model="user.password">
    <button @click="submit">提交</button>


</div>

</body>

<script>
    new Vue({
        el: '#app',
        data() {
            return {

                user: {
                    name: 'gavin',
                    password: '61285368'
                }

            }
        },
        methods: {
            submit: function () {
                /*   var login = Qs.stringify({

                       name: this.name,
                       password: this.password
                   });*/

                var login = JSON.stringify(this.user);

                console.log(login);
                axios({
                    method: 'post',
                    url: 'hello/axiosDemo',
                    headers: {
                        "Content-Type": "application/json"
                        //"Content-Type": "application/x-www-form-urlencoded"
                    },
                    data: login

                }).then((result) => {
                    console.log(result)
                }).catch((err) => {

                });


            }
        }
    })


</script>

</html>