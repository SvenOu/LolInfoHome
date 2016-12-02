Ext.define('SampleSystem.controller.MainController', {
	extend : 'Ext.app.Controller',
	refs : [
		{ref:'leftMenus',selector:'left-menus'},
		{ref:'mainPanel',selector:'main-panel'}
	],
	init : function() {
		var me=this;
		me.control({
			'left-menus':{
				afterrender: me.leftMenuSelectFirstItem,
				itemclick: me.leftMenuItemClick
			},
			'button[name=logout]':{
				click: me.logoff
			},
			'header-panel label[name=userName]':{
				afterrender: me.loadUserNameLabel
			}
		});
	},
	loadUserNameLabel: function(label){
		label.setText(app.user.username);
	},
	logoff: function(btn,e){
		window.location.href = '../j_spring_security_logout';
	},
	leftMenuSelectFirstItem: function(leftMenu){
		leftMenu.getSelectionModel().selectRange(0, 0);
		this.getMainPanel().addComponent('home','SampleSystem.view.detail.Home','home');
	},
	leftMenuItemClick: function(leftMenu, record, item, index, e){
		var keyName='',componentName='',name='';
		switch(record.get('functionCode')) {
		    case 'home':
		    	name=keyName='home';
		    	componentName='SampleSystem.view.detail.Home';
		        break;
		    case 'myWorks':
		    	name=keyName='myWork';
		    	componentName='SampleSystem.view.detail.MyWork';
		        break;
		    case 'archives':
		    	name=keyName='myInfo';
		    	componentName='SampleSystem.view.detail.MyInfo';
		    	break;
		    case 'interests':
		    	name=keyName='myInterests';
		    	componentName='SampleSystem.view.detail.MyInterests';
		    	break;
		    case 'ambitions':
		    	name=keyName='myDream';
		    	componentName='SampleSystem.view.detail.MyDream';
		    	break;
		}
		this.getMainPanel().addComponent(keyName,componentName,name);
	}
});