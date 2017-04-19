<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="false" %>

<html>
<head>
    <title>ProductData</title>

    <style type="text/css">
    .tg {
    border-collapse: collapse;
    border-spacing: 0;
    border-color: #ccc;
    }

    .tg td {
    font-family: Arial, sans-serif;
    font-size: 14px;
    padding: 10px 5px;
    border-style: solid;
    border-width: 1px;
    overflow: hidden;
    word-break: normal;
    border-color: #ccc;
    color: #333;
    background-color: #fff;
    }

    .tg th {
    font-family: Arial, sans-serif;
    font-size: 14px;
    font-weight: normal;
    padding: 10px 5px;
    border-style: solid;
    border-width: 1px;
    overflow: hidden;
    word-break: normal;
    border-color: #ccc;
    color: #333;
    background-color: #f0f0f0;
    }

    .tg .tg-4eph {
    background-color: #f9f9f9;
    }
</style>

</head>
<body>
<h1>Product Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="60">Price</th>
        <th width="120">Description</th>
    </tr>
        <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.price/100}.${product.price%100}</td>
        <td>${product.description}</td>
        </tr>
</table>
</body>
</html>
