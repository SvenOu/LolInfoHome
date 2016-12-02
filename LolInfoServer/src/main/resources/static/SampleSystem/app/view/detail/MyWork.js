Ext.define('SampleSystem.view.detail.MyWork', {
	extend: 'Ext.panel.Panel',
	xtype:'detail-mywork-panel',
	title: MS.myWorks,
	layout: 'vbox',
    items: [
    	{
    		xtype: 'button',
    		text: 'Church\'s Android App',
    		margin: 10,
    		handler: function(btn, e){
    			window.open('./resources/apks/Churchs_v1.5.5_live.apk');
    		}
    	},
    	{
    		xtype: 'button',
    		text: 'KrispyKcunchy Android App',
    		margin: 10,
    		handler: function(btn, e){
    			window.open('./resources/apks/KrispyKcunchy_v1.2.3_live.apk');
    		}
    	}
    ]
});