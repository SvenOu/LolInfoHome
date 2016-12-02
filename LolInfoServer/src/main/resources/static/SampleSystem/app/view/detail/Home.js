Ext.define('SampleSystem.view.detail.Home', {
	extend: 'Ext.panel.Panel',
	xtype:'detail-home-panel',
	title: MS.home,
	layout: 'fit',
    items: {
    	xtype: 'uxiframe',
    	src: './resources/html/ouzhijian_.html'
    }
});