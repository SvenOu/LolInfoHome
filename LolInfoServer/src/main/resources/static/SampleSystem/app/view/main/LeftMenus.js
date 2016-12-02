Ext.define('SampleSystem.view.main.LeftMenus', {
	extend: 'Ext.view.View',
    cls: 'sidebar-dataview',
    xtype:'left-menus',
    selectedItemCls: 'function-button-cur',
    itemSelector : 'div.function-button',
    overflowY :'auto',
    tpl: new Ext.XTemplate(
		'<tpl for=".">',
	        '<div id="{functionCode}" data-qwidth="300" data-qtip="{caption}" class="function-button">',
	        	'<div class="function-img"><img src="{src}" style="cursor: pointer;" /></div>',
	        '<p class="function-name">{caption}</p>',
	        '</div>',
	    '</tpl>'
	),
	initComponent : function() {
		this.store = Ext.create('SampleSystem.store.MenusStore');
		this.callParent(arguments);
	}
});