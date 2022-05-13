var editor;

window.onload = function() {
	editor = ace.edit("editor");

	editor.setOptions({
		enableBasicAutocompletion: true,
		enableLiveAutocompletion: true,
		enableSnippets: true,
		fontSize: 18,
		fontFamily: '',
		theme: 'ace/theme/monokai',
		tabSize: 4,
		mode: 'ace/mode/c_cpp'
	});
}

function changeLanguage() {
	var language = $("#language option:selected").text();
	language = language.replaceAll('\n','');
	language = language.replaceAll('\t','');
	language = language.toLocaleLowerCase();
	console.log('Language: ', language);
	if (language == 'C' || language == 'C++') {
		editor.setOptions({ mode: 'ace/mode/c_cpp' });
	}
	else {
		editor.setOptions({ mode: 'ace/mode/' + language });
	}
}