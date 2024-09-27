
import {config} from '../../request/config'
import {request} from '../../request/index.js'
const app = getApp()
const appG = app.globalData;
Page({
  data: {
    ZijiaxianluList:[]
  },
  onLoad: function () {
  },
  hsgadd(){
    wx.navigateTo({
      url: '/pages/Zijiaxianluadd/index'
    });
  },
  onShow:function(){
    let user = wx.getStorageSync('user');
    if (!user) {
      	wx.showToast({
        title: '请先登录',
        icon: 'none'
      }) 
      wx.navigateTo({
        url: '/pages/login/index'
      });
    } 
	else {
    }
    this.getAdminTextInfoList();
    },
    getAdminTextInfoList() {
      let user = wx.getStorageSync('user');
      request({url: '/zijiaxianluInfo'}).then(res => {
          if(res.code === '0') {
              let ZijiaxianluList = res.data;
              ZijiaxianluList.forEach(item => {
                if(!item.tupian || item.tupian === '[]') {
                    item.url = this.data.defaultImageUrl;
                } else {
                    let fileArr = JSON.parse(item.tupian)
                    item.url = config.baseFileUrl + fileArr[0];
                }
               
            });
              this.setData({
                ZijiaxianluList,
              })
          } else {
              wx.showToast({
                  title: res.msg,
                  icon: 'none'
              })
          }
      })
    },
	hsgdetail: function (e) {
      const { id } = e.currentTarget.dataset;
      wx.navigateTo({
        url: '/pages/zijiaxianludetail/index?id='+id,
      });
    },
    hsgshanchu: function (e) {
      const { id } = e.currentTarget.dataset;
      wx.showModal({
        content: '您是否要删除？',
        success: (res) => {
          if (res.confirm) {
            let user = wx.getStorageSync("user");
            request({url: '/zijiaxianluInfo/' + id, method: 'DELETE'}).then(res => {
              if (res.code === '0') {
                wx.showToast({
                  title: '删除成功',
                  icon: 'none'
                })
                this.getAdminTextInfoList();
              } else {
                wx.showToast({
                  title: res.msg,
                  icon: 'error'
                })
              }
            })
          }
        }
      })
     
    },
})