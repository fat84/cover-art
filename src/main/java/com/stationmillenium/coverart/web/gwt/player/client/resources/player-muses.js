//declare function to send tracking to piwik
$wnd.insertPlayer = function() {
	$wnd.MRP.insert({
	'url':'http://www.station-millenium.com/millenium.mp3',
	'codec':'mp3',
	'volume':100,
	'autoplay':true,
	'buffering':5,
	'title':'Station Millenium',
	'welcome':'Hits %26 Mix',
	'bgcolor':'#000000',
	'skin':'faredirfare',
	'width':269,
	'height':52,
	'elementId': 'museplayer'	
	});
	
}