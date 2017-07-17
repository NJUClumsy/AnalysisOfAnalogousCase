var React = require('react')

var GeneralInfo = function(props) {

    return <div className="general-info">
        <div className="general-info-title">
            概要
        </div>
        <div className="general-info-row">
            <div className="general-info-row-unit general-info-column-f">
                <div className="general-info-cell">
                    基本信息
                </div>
            </div>
            <div className="general-info-row-unit">
                <div className="general-info-cell">
                    案件类型
                </div>
                <div className="general-info-cell">
                    案由
                </div>
                <div className="general-info-cell general-info-row-l">
                    原被告
                </div>
            </div>
            <div className="general-info-row-unit general-info-column-m1">
                <div className="general-info-cell">
                    民事案件
                </div>
                <div className="general-info-cell">
                    机动车交通事故责任纠纷
                </div>
                <div className="general-info-cell general-info-row-l">
                    周瑞芬、张彩英、刘振财、吴苏花
                </div>
            </div>
        </div>
        <div className="general-info-row">
            <div className="general-info-row-unit general-info-column-f">
                <div className="general-info-cell">
                    案件特征
                </div>
            </div>
            <div className="general-info-row-unit general-info-column-m2">
                <div className="general-info-cell general-info-row-l">
                    碰撞受损、违反交通信号指示灯、未交交强险、超速行驶、人身损害
                </div>
            </div>
        </div>
        <div className="general-info-row">
            <div className="general-info-row-unit general-info-column-f">
                <div className="general-info-cell">
                    引用法条
                </div>
            </div>
            <div className="general-info-row-unit general-info-column-m2">
                <div className="general-info-cell general-info-row-l">
                    最高人民法院关于执行《中华人民共和国行政诉讼法》若干问题的解释 第十三条、第十九条、
                    二十一条等
                </div>
            </div>
        </div>
        <div className="general-info-row general-info-row-l">
            <div className="general-info-row-unit general-info-column-f">
                <div className="general-info-cell">
                    判决结果
                </div>
            </div>
            <div className="general-info-row-unit general-info-column-m2">
                <div className="general-info-cell general-info-row-l">
                    本案财产损失共计28915元，刘雪红只应承担70%的民事即20240.50元
                </div>
            </div>
        </div>
    </div>;
}

module.exports = GeneralInfo;