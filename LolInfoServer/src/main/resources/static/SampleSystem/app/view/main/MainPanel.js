Ext.define('SampleSystem.view.main.MainPanel', {
	extend: 'Ext.tab.Panel',
	xtype:'main-panel',
	cls:'main-view-panel',
    border: false,
    header: false,
    split: false,
    layout:{
    	type: 'fit'
    },
    addComponent: function(keyName,componentName,name){
    	var me = this;
        if(!me[keyName]){
            me[keyName] = Ext.create(componentName,{
                name: name,
                closable: true,
                listeners: {
                    'close': function(thisPanel,opts){
                        me[keyName]=false;
                    }
                }
            });
            me.add(me[keyName]);
        }
        me.setActiveTab(me[keyName]);
    }
});