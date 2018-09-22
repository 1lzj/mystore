<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div class="col-md-4">
        <img src="img/logo2.png" />
    </div>
    <div class="col-md-5">
        <img src="img/header.png" />
    </div>
    <div class="col-md-3" style="padding-top:20px">
        <ol class="list-inline">
            <c:if test="${sessionScope.user!=null}">
                你好！<li>${sessionScope.user.userName}</li>
                <li><a href="userServlet?methodName=logout">注销</a></li>
                <li><a href="cart.htm">购物车</a></li>
                <li><a href="cartServlet?methodName=myCart&uid=${sessionScope.user.uid}">我的订单</a></li>
            </c:if>
            <c:if test="${sessionScope.user==null}">
                <li><a href="login.jsp">登录</a></li>
                <li><a href="register.jsp">注册</a></li>

            </c:if>

        </ol>
    </div>
</div>
<!--
时间：2015-12-30
描述：导航条
-->
<div class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">首页</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" id="categoryList">


                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</div>

<script type="text/javascript">
    $.ajax({
        url:"categoryServlet?methodName=findAll",
        type:"get",
        dataType:"json",
        success:function (datas) {
           for(var i=0;i<datas.length;i++){

               $("#categoryList").append( "<li class='active'>"+"<a href="+"productServlet?methodName=findByCid&cid="+datas[i].cid+">"+datas[i].cName+"</a></li>");
           }


        }
    })
</script>