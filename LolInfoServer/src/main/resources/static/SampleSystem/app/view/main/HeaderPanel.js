Ext.define('SampleSystem.view.main.HeaderPanel', {
	extend: 'Ext.panel.Panel',
	xtype:'header-panel',
	bodyCls:'main-header-panel',
    height: 100,
    border: false,
    header: false,
    split: false,
    layout:{
    	type: 'hbox',
    	align:'stretch'
    },
    autoScroll:true,
    items:[
    	{
    		xtype:'container',
    		layout:{
    			type:'hbox',
    			pack:'start',
    			align:'middle'
    		},
    		items:[
    		    {
    		    	xtype:'image',
    		    	width:100,
    		    	height:80,
    		    	margin:'0 10 0 10',
    		    	src:'./resources/images/android-6-marshmallow-features.png'
    		    },
    		    {
    		    	xtype:'label',
    		    	cls:'header-title-text',
    		    	html:'有志者，事竟成，破釜沉舟，百二秦关终属楚 <br/>苦心人，天不负，卧薪尝胆，三千越甲可吞吴 '
    		    }
    		]
    	},
    	{
    		xtype:'box',
    		flex:1
    	},
    	{
    		xtype:'container',
    		layout:{
    			type:'hbox',
    			pack:'end',
    			align:'bottom'
    		},
    		items:[
    			{
    				xtype:'container',
    				layout:{
    					type:'vbox',
    					align:'center'
    				},
    				padding:10,
    				items:[
    				 	{
    				    	xtype:'label',
    				    	cls:'user-name',
    				    	name: 'userName'
    					},
						{
							xtype:'button',
							name:'logout',
							text: MS.logOff,
							height: 32,
							width: 134,
							cls : 'btn-log-off'
						}   
    				]
    			}
    		]
    	}
    ]
});