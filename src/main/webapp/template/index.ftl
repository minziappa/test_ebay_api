<#import "layout/defaultLayout.ftl" as layout>
<@layout.myLayout>
        <h3>Result from eBay API</h3>
        <p class="lead">${model.result?if_exists}</p>
</@layout.myLayout>