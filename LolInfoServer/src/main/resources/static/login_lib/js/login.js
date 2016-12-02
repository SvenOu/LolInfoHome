loginApp ={
	languageKey: 'code',
	defaultProfile: 'zh_CN',
	start: function(){
		this.loadCookieProfile();
		this.bindEvents();
	},
	loadCookieProfile: function(){
		var code = $.cookie(this.languageKey);
		if(code&&code.length>0){
			$('#language').val(code);
			this.loadLanguageLabels(code);
		}else{
			this.loadLanguageLabels(this.defaultProfile);
		}
	},
	saveCookieProfile: function(code){
		$.cookie(this.languageKey,code);
	},
	bindEvents:function(){
		var me = this;
		$('#username').keydown(function(event){
			if (event.keyCode == 13){
				$('#password').focus();
			}
		});
		
		$('#password').keydown(function(event){
			if (event.keyCode == 13){
				me.login();
			}
		});
		
		$('#btn-login').click(function(event){
			me.login();
		});
		
		$('#btn-reset').click(function(event){
			$('#username').val('').focus();
			$('#password').val('');
		});
		
		$('#language').change(function(event) {
			var code=$(this).val();
			me.loadLanguageLabels(code);
		});
		
	},
	loadLanguageLabels: function(code){
		var me =this;
		me.changeLanguage(code,function(locale){	
			$.getScript('controller/locale/messages.js', function(data, textStatus, jqxhr) {
				if(textStatus='success'){
					me.saveCookieProfile(code);
					me.refreshLables();
				}
			});
		});	
	},
	login: function(){
		var userName = $('#username').val(),
		password = $('#password').val();
		$("form").submit();
	},
	changeLanguage: function(locale,callback){
		$.ajax({
			url : 'controller/locale/changeLocale?locale=' + locale,
			type: 'GET',
			success : function(result) {
				if(result.success&&typeof(callback)=='function')
					callback(result.data.locale);
			}
		});
	},
	refreshLables: function(){
		$('#usernameLabel').text(MS.userId);
	 	$('#passwordLabel').text(MS.password);
	 	$('#languageLabel').text(MS.languageText);
	 	$('#btn-login').text(MS.login);
	 	$('#btn-reset').text(MS.reset);
	}
}
$(function(){
	loginApp.start();
});
