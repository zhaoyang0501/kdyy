jQuery.adminCompany = {
		companyDataTable:null,
		toSave:false,
		initSearchDataTable : function() {
			if (this.companyDataTable == null) {
				this.companyDataTable = $('#dt_table_view').dataTable({
					"sDom" : "<'row-fluid'<'span6'l>r>t<'row-fluid'<'span6'i><'span6'p>>",
					"sPaginationType" : "bootstrap",
					"oLanguage" : {
						"sLengthMenu" : "每页显示 _MENU_ 条记录",
						"sZeroRecords" : "抱歉， 暂时没有记录",
						"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
						"sSearch" : "",
						"sInfoEmpty" : "没有数据",
						"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
						"oPaginate" : {
							"sFirst" : "首页",
							"sPrevious" : "前一页",
							"sNext" : "后一页",
							"sLast" : "尾页"
						}
					},
					"bAutoWidth" : false,
					"iDisplayLength" : 10,
					"aLengthMenu" : [ 5, 10, 25, 50],
					"bServerSide" : true,
					"sServerMethod" : "POST",
					"bProcessing" : true,
					"bSort" : false,
					"sAjaxSource" : $.ace.getContextPath() + "/admin/company/list",
					"fnDrawCallback" : function(oSettings) {
						$('[rel="popover"],[data-rel="popover"]').popover();
					},
					"fnServerData" : function(sSource, aoData, fnCallback) {
						var name = $("#_name").val();
						if (!!name) {
							aoData.push({
								"name" : "name",
								"value" : name
							});
						}
						$.ajax({
							"dataType" : 'json',
							"type" : "POST",
							"url" : sSource,
							"data" : aoData,
							"success" : function(data){
								fnCallback(data);
							}
						});
					},
					"aoColumns" : [ {
						"mDataProp" : "id"
					},{
						"mDataProp" : "name"
					},{
						"mDataProp" : "addr"
					}, {
						"mDataProp" : "email"
					}, {
						"mDataProp" : "tel"
					}, {
						"mDataProp" : "site"
					}, {
						"mDataProp" : "pricestar"
					} ,{
						"mDataProp" : "priceadd"
					}, {
						"mDataProp" : ""
					}],
					"aoColumnDefs" : [
						{
							'aTargets' : [8],
							'fnRender' : function(oObj, sVal) {
								return ""+
								 "  <button class=\"btn2 btn-info\" onclick=\"$.adminCompany.deleteCompany("+oObj.aData.id+")\"><i class=\"icon-trash\"></i> 删除</button>";
							}
						},
					 {
						'aTargets' : [ '_all' ],
						'bSortable' : false,
						'sClass' : 'center'
					}]

				});
			} else {
				var oSettings = this.companyDataTable.fnSettings();
				oSettings._iDisplayStart = 0;
				this.companyDataTable.fnDraw(oSettings);
			}

		},
		deleteCompany :function(id){
			bootbox.confirm( "是否确认删除？", function (result) {
	            if(result){
	            	$.ajax({
	        			type : "get",
	        			url : $.ace.getContextPath() + "/admin/company/delete?id="+id,
	        			dataType : "json",
	        			success : function(json) {
	        				if(json.resultMap.state=='success'){
	        					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"success","timeout":"2000"});
	        					$.adminCompany.initSearchDataTable();
	        				}else{
	        					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"warning"});
	        				}
	        			}
	        		});
	            }
	        });
		},
		showaddModal: function(id){
			$.adminCompany.toSave=true;
			$("#user_modal_header_label").text("新增分类");
			$("#_modal").modal('show');
		},
		save :function (){
			if($.adminCompany.toSave){
				$.ajax({
	    			type : "post",
	    			url : $.ace.getContextPath() + "/admin/company/save",
	    			data:{
	    				"company.title":$("#title").val(),
	    				"company.context":$("#context").val()
	    			},
	    			dataType : "json",
	    			success : function(json) {
	    				if(json.resultMap.state=='success'){
	    					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"success","timeout":"2000"});
	    					$.adminCompany.initSearchDataTable();
	    					$("#_modal").modal('hide');
	    				}else{
	    					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"warning"});
	    				}
	    			}
	    		});
			}else{
				$.ajax({
	    			type : "post",
	    			url : $.ace.getContextPath() + "/admin/company/update",
	    			data:{
	    				"company.id":$("#id").val(),
	    				"company.title":$("#title").val(),
	    				"company.context":$("#context").val()
	    			},
	    			dataType : "json",
	    			success : function(json) {
	    				if(json.resultMap.state=='success'){
	    					$("#user_edit_modal").modal('hide');
	    					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"success","timeout":"2000"});
	    					$.adminCompany.initSearchDataTable();
	    					$("#_modal").modal('hide');
	    				}else{
	    					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"warning"});
	    				}
	    			}
	    		});
			}
		},
		showEdit: function (id){
			$("#id").val(id);
			$.adminCompany.toSave=false;
			$.ajax({
    			type : "get",
    			url : $.ace.getContextPath() + "/admin/company/get?id="+id,
    			dataType : "json",
    			success : function(json) {
    				if(json.resultMap.state=='success'){
    					$("#user_modal_header_label").text("修改分类");
    					$("#_modal").modal('show');
    					$("#title").val(json.resultMap.object.title);
    					$("#context").val(json.resultMap.object.context);
    				}else{
    					noty({"text":""+ json.resultMap.msg +"","layout":"top","type":"warning"});
    				}
    			}
    		});
		}
};