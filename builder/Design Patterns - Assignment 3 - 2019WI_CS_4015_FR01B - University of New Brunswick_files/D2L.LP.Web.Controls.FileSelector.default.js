
D2L.Control.FileSelector=D2L.Control.CustomSelector.extend({Construct:function(){arguments.callee.$.Construct.call(this);this.m_areaFilters=["MyComputer","OuFiles"];this.m_canDelete=true;this.m_customDialogs=new D2L.Util.Dictionary;this.m_selectedArea="";this.m_selectedAreaParam="";this.m_fileFilters=[D2L.Files.FilterType.All];this.m_maxFileSize=0;this.m_submitFileDialog=null;this.m_totalFileSize=0;this.m_raiseAddRemoveEvent=true;this.m_forceSaveToCourseFiles=false;this.OnAddRemove=new D2L.EventHandler},
AppendChild:function(file){file=arguments.callee.$.AppendChild.call(this,file);if(file)this.UpdateFileSizes();if(file&&this.m_raiseAddRemoveEvent)this.OnAddRemove.Trigger(file);return file},IntegrateControlMin:function(deserializer){arguments.callee.$.IntegrateControlMin.call(this,deserializer);this.m_maxFileSize=deserializer.GetMember();this.m_canDelete=deserializer.GetBoolean();this.m_fileFilters=deserializer.GetMember();this.m_areaFilters=deserializer.GetMember();this.m_selectedArea=deserializer.GetMember();
this.m_selectedAreaParam=deserializer.GetMember();this.m_forceSaveToCourseFiles=deserializer.GetBoolean();this.m_canViewLinkAttachments=deserializer.GetBoolean();var attachments;if(this.m_canViewLinkAttachments)attachments=deserializer.GetObjectArrayMin(D2L.Control.FileSelector.Attachment);else attachments=deserializer.GetObjectArrayMin(D2L.Control.FileSelector.File);this.m_integrationComplete=false;for(var i=0;i<attachments.length;i++)this.AppendChild(attachments[i]);this.m_integrationComplete=true},
RemoveChild:function(file,doRemove){file=arguments.callee.$.RemoveChild.call(this,file,doRemove);if(file)this.UpdateFileSizes();if(file&&this.m_raiseAddRemoveEvent)this.OnAddRemove.Trigger(file);return file},AddAreaFilter:function(area){area=area.toLowerCase();var found=false;for(var i=0;i<this.m_areaFilters.length;i++)if(this.m_areaFilters[i]==area){found=true;break}if(!found)this.m_areaFilters.push(area)},Clear:function(){while(this.Children().length>0)this.RemoveChild(this.Children()[0],true)},
GetTotalFileSize:function(){var total=0;for(var i=0;i<this.Children().length;i++)if(!this.Children()[i].IsDeleted()&&this.Children()[i].Type==="file")total+=this.Children()[i].GetFile().GetSize();return total},GetCount:function(){var count=0;for(var i=0;i<this.Children().length;i++)if(!this.Children()[i].IsDeleted())count+=1;return count},HasValue:function(){return new D2L.Util.DelayedReturn(this.HasValueNoDelay())},HasValueNoDelay:function(){var numChildren=0;for(var i=0;i<this.Children().length;i++)if(!this.Children()[i].IsDeleted())numChildren++;
return numChildren>0},OpenDialog:function(){if(!this.m_submitFileDialog){var me=this;var callback=function(dialogResponse){var files=dialogResponse.GetData("files");var sources=dialogResponse.GetData("sources");if(files)for(var i=0;i<files.length;i++){var file=D2L.Serialization.JsonDeserializer.Deserialize(D2L.Serialization.JsonSerializer.Serialize(files[i]),D2L.Files.FileInfo);var item=new D2L.Control.FileSelector.File(file,sources[file.FileId]);item.SetIsNew(true);me.AppendChild(item)}dialogResponse.GetDialog().Close()};
this.m_submitFileDialog=new D2L.Dialog.SelectFile(callback)}this.m_submitFileDialog.SetForceSaveToCourseFiles(this.m_forceSaveToCourseFiles);this.m_submitFileDialog.SetFileFilters(this.m_fileFilters);this.m_submitFileDialog.SetAreaFilters(this.m_areaFilters);this.m_submitFileDialog.SetSelectedArea(this.m_selectedArea,this.m_selectedAreaParam);this.m_submitFileDialog.SetAllowMultiple(this.m_allowMultiple);this.m_submitFileDialog.SetMaxFileSize(this.m_maxFileSize);this.m_submitFileDialog.Open(this)},
OpenCustomDialog:function(dialogClassName,dialogSrc,sourceName){var dialog=this.m_customDialogs.Get(dialogClassName);if(dialog===undefined){var me=this;var callback=function(dialogResponse){var file=dialogResponse.GetData("file");var source=new D2L.LP.Text.PlainText(sourceName);var item;if(file){file=D2L.Serialization.JsonDeserializer.Deserialize(D2L.Serialization.JsonSerializer.Serialize(file),D2L.Files.FileInfo);item=new D2L.Control.FileSelector.File(file,source);item.SetIsNew(true);me.AppendChild(item)}dialogResponse.GetDialog().Close()};
var dialogClass=eval(dialogClassName);dialog=new dialogClass(dialogSrc,callback);this.m_customDialogs.Add(dialogClassName,dialog)}dialog.Open(this)},OpenQuickLinkDialog:function(customTitle,sourceName,hideCancelButton){var dialogClassName="D2L.Dialog.QuickLink";var key=sourceName?dialogClassName+":"+sourceName:dialogClassName;var dialog=this.m_customDialogs.Get(key);var showCancelButton=hideCancelButton?false:true;if(dialog===undefined){var me=this;var callback=function(dialogResponse){var link=dialogResponse.GetData("QuickLink");
var source=new D2L.LP.Text.PlainText(sourceName);var item;if(link){link.Target="_blank";link.Navigation=link.Navigation.replace("{orgUnitId}",Global.OrgUnitId);item=new D2L.Control.FileSelector.Link(link,source);item.SetIsNew(true);me.AppendChild(item)}dialogResponse.GetDialog().Close()};dialog=new D2L.Dialog.QuickLink(callback,true,sourceName,false,customTitle,!sourceName,showCancelButton);this.m_customDialogs.Add(key,dialog)}dialog.Open(this.GetDomNode().id)},RemoveAreaFilter:function(area){area=
area.toLowerCase();for(var i=0;i<this.m_areaFilters.length;i++)if(this.m_areaFilters[i]==area){this.m_areaFilters.splice(i,1);break}if(area==this.m_selectedArea)this.m_selectedArea=""},RestoreItem:function(file){arguments.callee.$.RestoreItem.call(this,file);this.UpdateFileSizes();if(file&&this.m_raiseAddRemoveEvent)this.OnAddRemove.Trigger(file)},SetFile:function(file){file=D2L.Serialization.JsonDeserializer.Deserialize(file,D2L.Files.FileInfo);var existing=this.GetItem(file.FileId);this.m_integrationComplete=
false;if(existing){existing.SetSubject(file.GetFileName());existing.m_file=file;existing.m_domHasBeenBuilt=false;existing.BuildDom();this.UpdateFileSizes()}else{var fsFile=new D2L.Control.FileSelector.File(file);fsFile.SetCanDelete(this.m_canDelete);fsFile.SetIsNew(false);this.AppendChild(fsFile)}this.m_integrationComplete=true},SetFiles:function(files){this.m_raiseAddRemoveEvent=false;for(var i=0;i<files.length;i++)this.SetFile(files[i]);this.m_raiseAddRemoveEvent=true},SetAttachment:function(attachmentType,
attachment){this.m_integrationComplete=false;if(attachmentType==="file"){var file=D2L.Serialization.JsonDeserializer.Deserialize(attachment,D2L.Files.FileInfo);var existing=this.GetItem(file.FileId);if(existing){existing.SetSubject(file.GetFileName());existing.m_file=file;existing.m_domHasBeenBuilt=false;existing.BuildDom();this.UpdateFileSizes()}else{var fsFile=new D2L.Control.FileSelector.File(file);fsFile.SetCanDelete(this.m_canDelete);fsFile.SetIsNew(false);this.AppendChild(fsFile)}}else if(attachmentType===
"link"){var link=D2L.Serialization.JsonDeserializer.Deserialize(attachment,D2L.Control.Attachments.LinkAttachmentInfo);var existing=this.GetItem(link.LinkId);if(existing){existing.SetSubject(link.GetText());existing.m_link=link;existing.m_domHasBeenBuilt=false;existing.BuildDom()}else{var fsLink=new D2L.Control.FileSelector.Link(link);fsLink.SetCanDelete(this.m_canDelete);fsLink.SetIsNew(false);this.AppendChild(fsLink)}}this.m_integrationComplete=true},SetAttachments:function(attachments){this.m_raiseAddRemoveEvent=
false;for(var i=0;i<attachments.length;i++)this.SetAttachment(attachments[i][0],attachments[i][1]);this.m_raiseAddRemoveEvent=true},SetSelectedArea:function(selectedArea,param){selectedArea=selectedArea.toLowerCase();this.m_selectedArea=selectedArea;if(param!==undefined)this.m_selectedAreaParam=param;this.AddAreaFilter(selectedArea)},UpdateFileSizes:function(){this.m_totalFileSize=0;for(var i=0;i<this.Children().length;i++)if(!this.Children()[i].IsDeleted()&&this.Children()[i].Type==="file")this.m_totalFileSize+=
this.Children()[i].GetFile().Size}});D2L.FileSelector=D2L.Control.FileSelector;D2L.FileSelector.FILE_TYPES=new Array("Url","CourseFile","UploadedFile");
D2L.Control.FileSelector.Attachment=D2L.Control.CustomSelectorItem.extend({Construct:function(type,object,source){var inner=null;if(type!==undefined)switch(type){case "File":inner=new D2L.Control.FileSelector.File(object,source);break;case "Link":inner=new D2L.Control.FileSelector.Link(object,source);break}arguments.callee.$.Construct.call(this,"");this.m_inner=inner;this.m_type=type},DeserializeMin:function(deserializer){var type=deserializer.GetMember();switch(type){case "File":this.m_inner=deserializer.GetObjectMin(D2L.Control.FileSelector.File);
break;case "Link":this.m_inner=deserializer.GetObjectMin(D2L.Control.FileSelector.Link);break;default:this.m_inner=null;break}},BuildDom:function(){if(this.m_inner)this.m_inner.BuildDom()},GetLink:function(){if(this.m_inner)return this.m_inner.GetLink()},GetFile:function(){if(this.m_inner)return this.m_inner.GetFile()},Type:function(){return this.m_type},Focus:function(){if(this.m_inner)this.m_inner.Focus()},Rename:function(text){if(this.m_inner)this.m_inner.Rename()}});D2L.FileSelector.File=D2L.Control.FileSelector.File;
D2L.Control.FileSelector.File=D2L.Control.CustomSelectorItem.extend({Construct:function(file,source){var key="";if(file!==undefined)key=file.FileId;arguments.callee.$.Construct.call(this,key);this.m_file=file;this.m_fileLink=null;this.m_navigation="";this.m_source=null;this.m_deleteCellVAlign="top";if(file!==undefined){this.SetData("FileSystemType",file.GetFileSystemType());this.SetData("FileId",file.GetFileId());this.SetData("NewFileName","");this.SetSubject(file.GetFileName())}if(source!==undefined)this.m_source=
source},DeserializeMin:function(deserializer){var fileSystemType=deserializer.GetMember();var fileId=deserializer.GetMember();this.m_key=fileId;this.m_file=new D2L.Files.FileInfo(fileSystemType,fileId);this.m_canDelete=deserializer.GetBoolean();this.m_isDeleted=deserializer.GetBoolean();this.m_isNew=deserializer.GetBoolean();this.m_navigation=deserializer.GetMember();this.SetData("FileSystemType",this.m_file.GetFileSystemType());this.SetData("FileId",this.m_file.GetFileId());this.SetData("NewFileName",
"");this.SetSubject(this.m_file.GetFileName())},BuildDom:function(){arguments.callee.$.BuildDom.call(this);var container=this.CreateElement("div");if(!this.m_fileLink)this.m_fileLink=new D2L.Control.FileLink(this.m_file,this.m_source);else this.m_fileLink.SetFile(this.m_file,false);if(this.m_navigation.length>0)this.m_fileLink.SetNavigation(this.m_navigation);this.AppendChild(this.m_fileLink)},GetFile:function(){return this.m_file},Focus:function(){if(this.m_fileLink)this.m_fileLink.Focus()},Rename:function(newFileName){this.SetData("NewFileName",
newFileName);this.SetSubject(newFileName);this.m_file.Rename(newFileName);if(this.m_fileLink)this.m_fileLink.SetFile(this.m_file,false)},RenameFile:function(newFileName){this.Rename(newFileName)}});D2L.FileSelector.File=D2L.Control.FileSelector.File;
D2L.Control.FileSelector.Link=D2L.Control.CustomSelectorItem.extend({Construct:function(link,source){var key="";if(link!==undefined)key=link.LinkId||link.Navigation;arguments.callee.$.Construct.call(this,key);this.m_link=link;this.m_linkLink=null;this.m_source=null;this.m_deleteCellVAlign="top";if(link!==undefined){this.SetData("LinkId",link.LinkId);this.SetData("Navigation",link.Navigation);this.SetData("Text",link.Text||link.Navigation);this.SetData("Target",link.Target);this.SetSubject(link.Text||
link.Navigation)}if(source!==undefined)this.m_source=source},DeserializeMin:function(deserializer){var linkId=deserializer.GetMember();var navigation=deserializer.GetMember();var text=deserializer.GetMember();var target=deserializer.GetMember();var icon=deserializer.GetMember();this.m_key=linkId;this.m_link={LinkId:linkId,Navigation:navigation,Target:target,Text:text,Icon:icon};this.m_canDelete=deserializer.GetBoolean();this.m_isDeleted=deserializer.GetBoolean();this.m_isNew=deserializer.GetBoolean();
this.SetData("LinkId",link.LinkId);this.SetData("Navigation",link.Navigation);this.SetData("Text",link.Text||link.Navigation);this.SetData("Target",link.Target);this.SetSubject(link.Text||link.Navigation)},BuildDom:function(){arguments.callee.$.BuildDom.call(this);var link=this.CreateElement("a");link.className="d2l-text-imagelink";if(this.m_link.Icon){var img=this.CreateElement("img");img.className="d2l-text-imagelink-img";img.src=this.m_link.Icon;link.appendChild(img)}var span=this.CreateElement("span");
span.className="d2l-text-imagelink-text";span.textContent=this.m_link.Text;link.href=this.m_link.Navigation;link.target=this.m_link.Target;link.appendChild(span);this.AppendChild(link)},GetLink:function(){return this.m_link},Focus:function(){if(this.m_linkLink)this.m_linkLink.Focus()},Rename:function(text){this.SetData("Text",text);this.SetSubject(text);this.m_link.Text=text;if(this.m_linkLink)this.m_linkLink.SetText(text)}});D2L.FileSelector.File=D2L.Control.FileSelector.File;
if(window["D2L"]!==undefined&&D2L.LP.Web.Packaging!==undefined)D2L.LP.Web.Packaging.Register("D2L.LP.Web.Controls.FileSelector.default");