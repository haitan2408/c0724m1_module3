<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 23/12/2024
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách học sinh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <button class="btn btn-primary" onclick="window.location.href='/student?action=create'">Thêm mới</button>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Địa chỉ</th>
            <th>Điểm</th>
            <th>Lớp</th>
            <th colspan="2">Chức năng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student" varStatus="temp">
            <tr>
                <td>${temp.count}</td>
                <td>${student.name}</td>
                <td>${student.address}</td>
                <td>${student.point}</td>
                <td>${student.className}</td>
                <td>
                    <button class="btn btn-warning">Sửa</button>
                </td>
                <td>
                    <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modalDelete${student.code}">
                        Xóa
                    </button>
                </td>
                <div class="modal fade" id="modalDelete${student.code}" tabindex="-1"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Xóa học sinh</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <p>Bạn có chắc muốn xóa học sinh có tên là ${student.name} và id là ${student.code}?</p>
                                <small style="color: red; font-style: italic">Lưu ý hành động này không thể hoàn
                                    tác!</small>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                                <button type="button" class="btn btn-danger"
                                        onclick="window.location.href='/student?action=delete&id=${student.code}'">Xác
                                    nhận
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${message != null}">
        <div class="alert alert-success" role="alert" id="message">
                ${message}
        </div>
    </c:if>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script>
    setTimeout(function () {
        document.getElementById("message").remove();
    },3000)
</script>
</html>
