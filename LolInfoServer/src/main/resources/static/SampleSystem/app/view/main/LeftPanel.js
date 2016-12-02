Ext.define('SampleSystem.view.main.LeftPanel', {
	extend: 'Ext.panel.Panel',
	xtype:'left-panel',
    title: MS.menu,
	bodyCls: 'main-left-panel',
    border: false, 
    animCollapse: true,
    collapsible: true,
    split: true,
    width: 115,
    layout:{
    	type: 'fit'
    },
    items: {
    	xtype:'left-menus'
    }
});