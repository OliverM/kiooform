var Collapsible = React.createClass({
    displayName: 'CommentBox',
    render: function(){
        return (React.createElement(
            'div',
            {className: 'comment-box'},
            this.props.comment
        ));
    }});