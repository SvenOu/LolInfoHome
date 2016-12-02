Ext.define('SampleSystem.store.MenusStore',{
	extend:'Ext.data.Store',
	model:'SampleSystem.model.MenusModel',
	autoLoad:false,
	data: [
		{ src:'./resources/images/icon_action_plan.png', caption: MS.home, functionCode:'home'},
		{ src:'./resources/images/icon_new.png', caption: MS.myWorks, functionCode:'myWorks' },
		{ src:'./resources/images/icon_excel.png', caption: MS.archives, functionCode:'archives' },
		{ src:'./resources/images/icon_ops_manual.png', caption: MS.interests, functionCode:'interests' },
		{ src:'./resources/images/icon_help.png', caption: MS.ambitions, functionCode:'ambitions' }     
	]
});