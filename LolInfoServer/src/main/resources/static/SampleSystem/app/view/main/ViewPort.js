Ext.define('SampleSystem.view.main.ViewPort', {
    extend: 'Ext.container.Viewport',
    xtype: 'app-viewport', 
    layout: {
        type: 'border'
    },
    items: [
		{
			xtype:'header-panel',
		    region: 'north'
		},
		{
			xtype:'main-panel',
			region:'center'
		},
		{
			xtype:'left-panel',
			region:'west'
		}
    ]
});
