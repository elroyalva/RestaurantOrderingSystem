<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="css/kitchen-style.css" rel="stylesheet" />
    <link href="css/bootstrap-theme.css" rel="stylesheet" />
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/kitchen.js"></script>
    <title>Tables</title>
    <meta charset="utf-8" />
</head>
<body>
    <div id="container" class="outline">
        <div class="logo">
            <span>LOGO PLACEHOLDER</span>
        </div>
        <div class="tables-container">
            <div class="resto-tables">

            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="order-placed-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Orders</h4>
                    </div>
                    <div class="modal-body">
                        <ul class="orders-list list-group"></ul>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Back</button>
                        <button type="button" id="modal-save" class="btn btn-primary">Complete</button>
                    </div>
                </div>
            </div>
        </div>


    </div>
</body>
</html>
