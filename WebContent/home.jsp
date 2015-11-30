<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>WinJS Demo</title>
	<link href="css/ui-light.css" rel="stylesheet" />
	<link href="css/style.css" rel="stylesheet" />
	<%
        String message = (String)request.getSession().getAttribute("message");
	%>
	<script type="text/javascript">
	var restoData = <%=message%>;	
	</script>
	<script src="js/base.js"></script>
	<script src="js/ui.js"></script>
	<script src="js/new.js"></script>
</head>
<body>

<%
Integer id = (Integer)request.getSession().getAttribute("rest_id");
Map<Integer, Set<Integer>> data = (Map<Integer, Set<Integer>>)getServletContext().getAttribute("table_data");
Set<Integer> freeTables = data.get(id);
Integer toDelete = null;
toDelete = Integer.parseInt(request.getParameter("number"));
freeTables.remove(toDelete);
%>
	<div id="app">
	    <div class="splitView" data-win-control="WinJS.UI.SplitView">
	        <!-- Pane area -->
	        <div>
	            <div class="header">
	                <button
	                    class="win-splitviewpanetoggle"
	                    data-win-control="WinJS.UI.SplitViewPaneToggle"
	                    data-win-options="{ splitView: select('.splitView') }"
	                ></button>
	                <div class="title" id="rest_name">McDonalds</div>
	            </div>

	            <div class="nav-commands">
	                <div class="addrLink" data-win-control="WinJS.UI.SplitViewCommand" data-win-options="{ label: 'Address', icon: 'home'}"></div>
	                <div data-win-control="WinJS.UI.SplitViewCommand" data-win-options="{ label: 'Favorite', icon: 'favorite'}"></div>
	                <div data-win-control="WinJS.UI.SplitViewCommand" data-win-options="{ label: 'Settings', icon: 'settings'}"></div>
	            </div>
	        </div>

	        <!-- Content area -->
	        <div class="logoBar" style="height:12.5%; margin-left: 20px;"> 
	        	<img src ="empty.jpg" class="logoImage" id="logo"/>
	        </div>
	        <script type="text/javascript">
				document.getElementById("logo").src = restoData.logo;
			</script>
	        
	        <div class="contenttext">
	        	<!-- Simple template for the ListView instantiation  -->
				<div class="smallListIconTextTemplate" data-win-control="WinJS.Binding.Template" style="display: none">
				    <div class="smallListIconTextItem" >
				        <img src="#" class="smallListIconTextItem-Image" data-win-bind="src: picture" />
				        <div class="smallListIconTextItem-Detail">
				            <h4 class="win-h4" data-win-bind="textContent: title"></h4>
				        </div>
				    </div>
				    <div><p data-win-bind="textContent: text"></p></div>
				    <div class="remove" ></div>
				</div>
				<div class="gridLayoutLeftHeaderTemplate" data-win-control="WinJS.Binding.Template">
				    <div class="gridLayoutLeftHeaderTemplateRoot">
				        <div data-win-bind="innerHTML: title"></div>
				    </div>
				</div>

				<!-- The declarative markup necesary for ListView instantiation -->
				<!-- Call WinJS.UI.processAll() in your initialization code -->
				<div id="listview"
				     class="win-selectionstylefilled"
				     data-win-control="WinJS.UI.ListView"
				     data-win-options="{
				        itemDataSource: Sample.ListView.data.dataSource,
				        itemTemplate: select('.smallListIconTextTemplate'),
				        groupDataSource: Sample.ListView.data.groups.dataSource,
				        groupHeaderTemplate: select('.gridLayoutLeftHeaderTemplate'),
				        selectionMode: 'none',
				        tapBehavior: 'invokeOnly',
				        layout: { type: WinJS.UI.GridLayout, groupHeaderPosition: 'left'
				     }
				}"></div>

			</div>
			<div class="lowerBar">
				<button class="callForService" style="margin-left: 30%" align="center">Call For Service</button>
				<button class="callForService" align="center">Generate Bill</button>
			</div>

			<div class="orderSection" style="overflow: hidden">
				<div class="orderListTemplate" data-win-control="WinJS.Binding.Template" style="display: none">
				    <div class="orderListItemText">
				        <img src="#" class="orderListItemText-Image" data-win-bind="src: picture" />
				        <div class="orderListeItemText-Detail">
				            <h4 class="win-h4" data-win-bind="textContent: title"></h4>
				            <h6 class="win-h6" data-win-bind="textContent: text"></h6>
				        </div>
				    </div>
				</div>

				<!-- The declarative markup necesary for ListView instantiation -->
				<!-- Call WinJS.UI.processAll() in your initialization code -->
				<div id="OrderslistView"
				     class="win-selectionstylefilled"
				     data-win-control="WinJS.UI.ListView"
				     data-win-options="{
				            itemDataSource: Order.ListView.data.dataSource,
				            itemTemplate: select('.orderListTemplate'),
				            selectionMode: 'none',
				            tapBehavior: 'none',
				            layout: { type: WinJS.UI.ListLayout }
				    }">
				</div>
				<button style="margin-left: 10%" class="placeO" onclick="placeOrder()">Place Order</button>
				<button class="placeO" onclick="resetOrder()">Reset Order</button>
			</div>
	    </div> 
	</div>
	<div id="addressDialog" data-win-control="WinJS.UI.ContentDialog" data-win-options="{
             title: 'Our Address:',
             primaryCommandText: 'Close'
        }">
    </div>
	<script src="js/new.js"></script>

</body>
</html>