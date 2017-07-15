<html>
<head>
    <script type="text/javascript">
        function getUserInfoJson() {
            var url = "/userinfo/returnJson";
            var args = {};
            $.post(url, args, function(){});
        }
    </script>
</head>
<body>
<h2>Hello World!</h2>
<a href="javascript:void(0)" id="returnJson" onclick="getUserInfoJson()">
    Test Json
</a>
</body>
</html>
